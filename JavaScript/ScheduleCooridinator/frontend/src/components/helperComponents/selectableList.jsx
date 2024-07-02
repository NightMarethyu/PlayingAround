import React, { useState, useCallback, useEffect } from 'react';

const SelectableList = ({ items, onSelectionFinalize, day }) => {
  const [selectedItems, setSelectedItems] = useState([]);
  const [isSelecting, setIsSelecting] = useState(false);

  const handleMouseDown = useCallback((e, item) => {
    document.body.classList.add('no-select');
    setIsSelecting(true);
    // Start a new selection block with the current item
    setSelectedItems(prev => [...prev, [item]]);
  }, []);

  const handleMouseMove = useCallback((e, item) => {
    if (!isSelecting) return;
    // Add the item to the last selection block if it's not already included
    setSelectedItems(prev => {
      const lastBlock = prev[prev.length - 1];
      if (!lastBlock.includes(item)) {
        return [...prev.slice(0, -1), [...lastBlock, item]];
      }
      return prev;
    });
  }, [isSelecting]);

  const handleMouseUp = useCallback(() => {
    document.body.classList.remove('no-select');
    setIsSelecting(false);
    // Call onSelectionFinalize with the selectedItems
    onSelectionFinalize(selectedItems.flat());
  }, [selectedItems, onSelectionFinalize]);

  // Clean up the no-select class on component unmount
  useEffect(() => {
    return () => {
      document.body.classList.remove('no-select');
    };
  }, []);

  return (
    <div onMouseUp={handleMouseUp}>
      {items.map((item, index) => (
        <div
          className='hour-cell'
          key={day + index}
          onMouseDown={(e) => handleMouseDown(e, item)}
          onMouseMove={(e) => handleMouseMove(e, item)}
          style={{
            padding: '10px',
            margin: '5px',
            backgroundColor: selectedItems.flat().includes(item) ? 'lightblue' : 'transparent',
            cursor: 'pointer',
          }}
        >
          {item}
        </div>
      ))}
    </div>
  );
};

export default SelectableList;
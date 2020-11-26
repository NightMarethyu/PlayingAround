export const reducer = (state, action) => {
  if (action.type === 'ADD_ITEM') {
    const newPeople = [...state.people, action.payload]
    return {
      ...state, 
      people: newPeople, 
      isModalOpen: true, 
      modalContent: "Item Added"
    }
  } 
  if (action.type === 'NO_VALUE') {
    return {...state, isModalOpen: true, modalContent: "Please enter value"}
  }
  if (action.type === 'CLOSE_MODAL') {
    return {...state, isModalOpen: false}
  }
  if (action.type === 'REMOVE_ITEM') {
    const newPeople = [...state.people.filter((person) => person.id !== action.payload)]
    return {
      ...state,
      people: newPeople,
      isModalOpen: true,
      modalContent: "Person Removed"
    }
  }
  throw new Error ('No matching action type')

  // I wanted to test if this would work with a switch statement
  // It does, in case you were wondering

  /* switch (action.type) {
    case 'ADD_ITEM':
      const newPeople = [...state.people, action.payload];
      return {
        ...state, 
        people: newPeople, 
        isModalOpen: true, 
        modalContent: "Item Added"
      };
    case 'NO_VALUE':
      return {...state, isModalOpen: true, modalContent: "Please enter value"};
    case 'CLOSE_MODAL':
      return {...state, isModalOpen: false}
    case 'REMOVE_ITEM':
      const newPeople = [...state.people.filter((person) => person.id !== action.payload)]
      return {
        ...state,
        people: newPeople,
        isModalOpen: true,
        modalContent: "Person Removed"
      }
    default:
      throw new Error ('No matching action type');
  } */
}
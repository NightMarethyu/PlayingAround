const PaginationComponent = ({ currentPage, totalPages, handlePageChange }) => {
  // Calculate the range of pages to display
  const pageNumbers = [];
  let startPage, endPage;
  if (totalPages <= 7) {
    // Less than 7 total pages so show all
    startPage = 1;
    endPage = totalPages;
  } else {
    // More than 7 total pages so calculate start and end pages
    if (currentPage <= 4) {
      startPage = 1;
      endPage = 5;
    } else if (currentPage + 2 >= totalPages) {
      startPage = totalPages - 4;
      endPage = totalPages;
    } else {
      startPage = currentPage - 2;
      endPage = currentPage + 2;
    }
  }
  // Push the calculated range of pages to pageNumbers array
  for (let i = startPage; i <= endPage; i++) {
    pageNumbers.push(i);
  }

  return (
    <nav aria-label="Page navigation" className="d-flex justify-content-center">
      <ul className="pagination position-relative bottom-0 start-50 translate-middle-x">
        <li className={`page-item ${currentPage === 1 ? 'disabled' : ''}`}>
          <a className="page-link" href="#!" onClick={() => handlePageChange(currentPage - 1)}>Previous</a>
        </li>
        {currentPage > 4 && totalPages > 7 && (
          <>
            <li className="page-item">
              <a className="page-link" href="#!" onClick={() => handlePageChange(1)}>1</a>
            </li>
            {currentPage > 5 && <li className="page-item disabled"><span className="page-link">...</span></li>}
          </>
        )}
        {pageNumbers.map(number => (
          <li key={number} className={`page-item ${number === currentPage ? 'active' : ''}`}>
            <a className="page-link" href="#!" onClick={() => handlePageChange(number)}>{number}</a>
          </li>
        ))}
        {currentPage < (totalPages - 3) && totalPages > 7 && (
          <>
            {currentPage < (totalPages - 4) && <li className="page-item disabled"><span className="page-link">...</span></li>}
            <li className="page-item">
              <a className="page-link" href="#!" onClick={() => handlePageChange(totalPages)}>{totalPages}</a>
            </li>
          </>
        )}
        <li className={`page-item ${currentPage === totalPages ? 'disabled' : ''}`}>
          <a className="page-link" href="#!" onClick={() => handlePageChange(currentPage + 1)}>Next</a>
        </li>
      </ul>
    </nav>
  );
};

export default PaginationComponent;
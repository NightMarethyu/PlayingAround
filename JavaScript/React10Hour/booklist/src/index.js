import React from 'react'
import ReactDom from 'react-dom'

// CSS
import './index.css'

// Additional JS files
import {books} from './books'
import Book from './Book'


function BookList() {
    return ( 
    <section className="booklist">
        {books.map((book, index) => {
            // const { img, title, author, alt } = book
            return (
                <Book key={book.id} book={book} index={index} />
            )
        })}
    </section>
    );
};

ReactDom.render( <BookList /> , document.getElementById('root'));

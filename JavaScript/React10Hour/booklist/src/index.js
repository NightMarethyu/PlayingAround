import React from 'react'
import ReactDom from 'react-dom'

// CSS
import './index.css'

// I wanted to clear up the JavaScript and keep my notes. I've got a bunch of notes from
// the video lecture and stuff in the notes-index.js.txt file

//setup vars
const firstBook = {
    img: 'https://images-na.ssl-images-amazon.com/images/I/9147oFAfHlL._AC_UL200_SR200,200_.jpg',
    title: 'Rhythm of War',
    author: 'Brandon Sanderson',
    alt: 'Rhythm of War'
}
const secondBook = {
    img: 'https://m.media-amazon.com/images/I/81PbZbbHNQL._AC_UY218_.jpg',
    title: 'The Way of Kings',
    author: 'Brandon Sanderson',
    alt: 'The Way of Kings'
}

// I'm going to add a "children prop", it's going to be in between the component tags
// rather than in the component declaration

// children is a keyword, so be careful when using it. It seems to be pretty useful, but
// I'm sure it can be misused pretty easily

function BookList() {
    return ( 
    <section className="booklist">
        <Book 
            img={firstBook.img} 
            title={firstBook.title} 
            alt={firstBook.alt} 
            author={firstBook.author}
        >
            <p>Coming November 17, 2020</p>
        </Book>
        <Book 
            img={secondBook.img} 
            title={secondBook.title} 
            alt={secondBook.alt} 
            author={secondBook.author}
        />
    </section>
    );
};

// I'm using Object Destructuring here to make the code look a little cleaner.
// As with most things there are a many ways to do this but I like how this looks.

const Book = ({img, title, author, alt, children}) => {
    return (
        <article className="book" >
            <img src={img} alt={alt} />
            <h1>{title}</h1>
            <h4>{author}</h4>
            {children}
        </article>
    );
};

ReactDom.render( <BookList /> , document.getElementById('root'));

import React from 'react'
import ReactDom from 'react-dom'

// stateless functional component
    // all components in React need to be capitalized (Greeting instead of greeting)
    // doing this tells React that it is a special React function not just a helper function or something like that
// always return JSX
    // const Greeting = () => {
    //     return React.createElement('h1',{},'You are already dead');
    // }

// JSX Rules
// Return single element
    // This means that you can have lots of html in a return statement, but they NEED to be wrapped in a single element, like a <div>
// div / section / article or Fragment
    // Use common HTML formatting, don't just use div tags, be specific
    // React has "Fragments" you can use this instead of using divs or other html elements
    // add fragments with: <React.Fragment></React.Fragment>, a shortcut is <></>
// use camelCase for html attribute
// className instead of class
    // to add a class to an attribute for styling or other reasons, it needs to be className, not just class
    // remember class is a JavaScript keyword
// close every element
// formatting

// Nested Components, React Tools


function Greeting() {
    return ( 
    <div>
        <h1>Demon Slayer The Movie: Mugen Train</h1>
        <p>Is one of the highest grossing films in Japanese Cinemas.</p>
        <Character />
        <CharaDescription />
    </div>
    );
}

const Character = () => <h2>Kamado Tanjiro</h2>
const CharaDescription = () => {
    return (
    <p>
        {'Tanjiro is the main character of Demon Slayer ' + String.fromCharCode(8211) + ' Kimetsu no Yaiba. His family was attacked and killed by a demon, so he joined the Demon Slayer Corps.'}
    </p>
    );
}

ReactDom.render( <Greeting /> , document.getElementById('root'));

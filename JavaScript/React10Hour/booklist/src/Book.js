import React from 'react'

const Book = (props) => {
    const {img, title, author, alt} = props.book
    const index = props.index + 1
    
    const clickHandler = (e) => {
        console.log(e)
        console.log(e.target)
        alert('Life before death. Strength before weakness. Journey before destination.')
    }

    const complexExample = (alt) => {
        console.log(alt)
    }

    return (
        <article className="book" >
            <div className="item-number">
                {index}
            </div>
            <img onMouseOver={() => {
                console.log(author)
            }} src={img} alt={alt} />
            <h1 onClick={() => console.log(title)}>{title}</h1>
            <h4>{author}</h4>
            <button type="button" onClick={clickHandler}>Speak the Words</button>
            <button type="button" onClick={() => complexExample(alt)}>Image Alt</button>
        </article>
    );
};

export default Book
package main

import "fmt"

// interfaces are used to define a set of methods
// basically if it has the things listed in the
// interface it will be of that type
type bot interface {
	getGreeting() string
}

type englishBot struct{}
type spanishBot struct{}

func main() {
	eb := englishBot{}
	sb := spanishBot{}

	printGreeting(eb)
	printGreeting(sb)
}

func printGreeting(b bot) {
	fmt.Println(b.getGreeting())
}

func (englishBot) getGreeting() string {
	// VERY custom logic for english greetings
	return "Hello There\nGeneral Kenobi"
}

func (spanishBot) getGreeting() string {
	// VERY custom logic for spanish greeting
	return "Hola a todos\nKenobi general"
}

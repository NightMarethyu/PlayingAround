package main

import "fmt"

func main() {
	// var colors map[string]string

	colors := make(map[int]string)

	// colors := map[string]string{
	// 	"red":   "#ff0000",
	// 	"green": "#00ff00",
	// 	"blue":  "#0000ff",
	// }

	// Go lets you use dot notation for structs but not for maps
	// so if we have a struct called structName and a value of
	// white in the struct we can access it using structName.white
	// Maps can only be accessed using the square brackets notation
	// so mapName[key]
	colors[10] = "#ffffff"

	delete(colors, 10)

	fmt.Println(colors)
}

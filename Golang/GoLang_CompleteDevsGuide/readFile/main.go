package main

import (
	"fmt"
	"io"
	"os"
)

func main() {
	ag := os.Args[1]
	file, err := os.Open(ag)
	if err != nil {
		fmt.Println("Error reading file:", err)
		os.Exit(1)
	} else {
		io.Copy(os.Stdout, file)
	}
}

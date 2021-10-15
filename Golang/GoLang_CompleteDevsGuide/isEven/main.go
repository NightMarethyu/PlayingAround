package main

import "fmt"

func main() {
	ints := []int{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}

	for _, v := range ints {
		if v%2 == 0 {
			fmt.Println(v, " is Even")
		} else {
			fmt.Println(v, " is Odd")
		}
	}
}

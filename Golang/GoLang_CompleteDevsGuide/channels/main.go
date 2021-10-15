package main

import (
	"fmt"
	"net/http"
	"time"
)

func main() {
	urls := []string{
		"google.com",
		"facebook.com",
		"golang.org",
		"amazon.com",
		"funimation.com",
		"vrv.co",
		"youtube.com",
		"gmail.com",
		"reddit.com",
	}

	c := make(chan string)

	for _, link := range urls {
		lk := "https://" + link
		go checkLink(lk, c)
	}

	for l := range c {
		go func(link string) {
			time.Sleep(5 * time.Second)
			checkLink(link, c)
		}(l)
	}
}

func checkLink(l string, c chan string) {
	_, err := http.Get(l)
	if err != nil {
		fmt.Println(l, "might be down!")
		c <- l
		return
	}

	fmt.Println(l, "is up")
	c <- l
}

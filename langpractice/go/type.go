package main


import "fmt"


func main() {
        var x float64 = 20
        y := 42
        z := 42
        y = 20.0
        fmt.Printf("%T\n", x)
        fmt.Printf("%T\n", y)
        fmt.Printf("%T\n", z)
}

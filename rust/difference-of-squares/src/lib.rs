pub fn square_of_sum(num: i32) -> i32{
    let sum = (1..num+1).fold(0, |acc, i| acc + i);
    sum * sum
}

pub fn sum_of_squares(num: i32) -> i32 {
    (1..num+1).map(|i| i * i).fold(0, |s, i| s + i)
}

pub fn difference(num: i32) -> i32 {
    square_of_sum(num) - sum_of_squares(num)
}

fn div_by(num: &i32, denom: &i32) -> bool {
    num % denom == 0
}

pub fn sum_of_multiples(num: i32, factors: &Vec<i32>) -> i32 {
    (0..num)
        .filter(|i| factors.iter().any(|f| div_by(i, f)))
        .fold(0, |sum, i| sum + i)
}

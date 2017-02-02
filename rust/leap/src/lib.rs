fn divis(left: i32, right: i32) -> bool {
    left % right == 0
}
pub fn is_leap_year(year: i32) -> bool {
    divis(year, 400) || (divis(year, 4) && !divis(year, 100))
}

pub fn square(s: u32) -> u64 {
    assert!(s > 0 && s < 65, "Square must be between 1 and 64");
    (1..s).fold(1, |last_square, _| last_square * 2)
}

pub fn total() -> u64 {
    (1..65)
        .map(|i| square(i))
        .fold(0, |sum, grains| sum + grains)
}

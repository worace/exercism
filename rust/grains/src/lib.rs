struct Grains {
    current: u64,
}

impl Grains {
    fn new() -> Grains {
        Grains { current: 1 }
    }
}

impl Iterator for Grains {
    type Item = u64;
    fn next(&mut self) -> Option<u64> {
        let current = self.current;
        if current < (u64::max_value() / 2) {
            self.current = self.current * 2;
            Some(current)
        } else {
            Some(current)
        }
    }
}

pub fn square(s: u32) -> u64 {
    assert!(s > 0 && s < 65, "Square must be between 1 and 64");
    match Grains::new().take(s as usize).last() {
        Some(i) => i,
        _ => 0
    }
}

pub fn total() -> u64 {
    Grains::new().take(64).fold(0, |sum, square| sum + square)
}

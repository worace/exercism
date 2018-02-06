pub fn reverse(input: &str) -> String {
    let mut out = "".to_string();
    for c in input.chars().rev() {
        out.push(c)
    }
    out.to_string()
}

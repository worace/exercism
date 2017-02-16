pub fn hamming_distance(left: &str, right: &str) -> Result<i32, String> {
    if left.chars().count() != right.chars().count() {
        Err("Strings must be same length".to_string())
    } else {
        Ok(left.chars().zip(right.chars()).fold(0, |distance, (lchar, rchar)| {
            if lchar != rchar {
                distance + 1
            } else {
                distance
            }
        }))
    }
}

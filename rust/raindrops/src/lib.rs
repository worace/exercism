use std::collections::BTreeMap;

pub fn raindrops(num: i32) -> String {
    let mut sounds = BTreeMap::new();
    sounds.insert(3, "Pling");
    sounds.insert(5, "Plang");
    sounds.insert(7, "Plong");

    let mut result = "".to_string();

    for (factor, sound) in sounds.iter() {
        if num % factor == 0 {
            result = result + sound;
        }
    }
    match result.len() {
        0 => num.to_string(),
        _ => result
    }
}

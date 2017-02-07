fn bottle(num: i32) -> String {
    match num {
        1 => "bottle".to_string(),
        _ => "bottles".to_string()
    }
}

fn body_verse(num: i32) -> String {
    let bottle_s = bottle(num);
    format!("{} {} of beer on the wall, {} {} of beer.\nTake one down and pass it around, {} {} of beer on the wall.\n",
            num,
            bottle_s,
            num,
            bottle_s,
            (num - 1),
            bottle(num - 1))
}

pub fn verse(num: i32) -> String {
    match num {
        0 => "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n".to_string(),
        1 => "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n".to_string(),
        _ => body_verse(num).to_string()
    }
}

pub fn sing(start: i32, end: i32) -> String {
    let verses: Vec<String> = (end..start+1)
        .rev()
        .map(|i| { verse(i) })
        .collect();
    verses.join("\n")
}

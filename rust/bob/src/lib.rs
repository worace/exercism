fn is_shouting(message: &str) -> bool {
    message.to_uppercase() == message
}

fn is_question(message: &str) -> bool {
    message.ends_with("?")
}

pub fn reply(message: &str) -> String {
    if message.is_empty() {
        "Fine. Be that way!".to_string()
    } else if is_shouting(message) {
        "Whoa, chill out!".to_string()
    } else if is_question(message){
        "Sure.".to_string()
    } else {
        "Whatever.".to_string()
    }
}

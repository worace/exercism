#if !defined(BOB_H)
#define BOB_H

#include <string>
#include <boost/algorithm/string.hpp>
#include <boost/regex.hpp>

namespace bob {
  const boost::regex letters{"[[:alpha:]]"};

  bool ends_with(const std::string& message, const char letter) {
    return message.at(message.length() - 1) == letter;
  }

  bool is_shouting(const std::string& message) {
    std::string upper = boost::to_upper_copy(message);
    return upper == message;
  }

  bool has_letters(const std::string& message) {
    return boost::regex_search(message, letters);
  }

  std::string hey(const std::string& msg) {
    std::string message = boost::trim_copy(msg);
    if (message.length() == 0) {
      return "Fine. Be that way!";
    } else if (is_shouting(message) && has_letters(message)) {
      return "Whoa, chill out!";
    } else if (ends_with(message, '?')) {
      return "Sure.";
    } else {
      return "Whatever.";
    }
  }
}
#endif

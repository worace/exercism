#if !defined(HAMMING_H)
#define HAMMING_H

#include <string>

namespace hamming {
  int compute(const std::string& left, const std::string& right) {
    if (left.length() != right.length()) {
      throw std::domain_error("Strings have different length");
    }

    int difference = 0;

    for (int i = 0; i < left.length(); i++) {
      if (left[i] != right[i]) {
        difference += 1;
      }
    }

    return difference;
  }
}
#endif

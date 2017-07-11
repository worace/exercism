#if !defined(ANAGRAM_H)
#define ANAGRAM_H

#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

namespace anagram {
  class anagram {
  public:
    std::string word;
    anagram(std::string w) {
      word = w;
      lowered = lower(word);
      token = tokenize(w);
    };

    std::vector<std::string> matches(std::vector<std::string> candidates) {
      std::vector<std::string> matches;

      for(int i = 0; i < candidates.size(); i++) {
        if (tokenize(candidates[i]) == token && lower(candidates[i]) != lowered) {
          matches.push_back(candidates[i]);
        }
      }
      return matches;
    };
  private:
    std::string lowered;
    std::string token;

    void print(std::string str) {
      std::cout << str << std::endl;
    }

    std::string lower(std::string word) {
      std::string lowered = word;
      std::transform(lowered.begin(), lowered.end(), lowered.begin(), ::tolower);
      return lowered;
    }

    std::string tokenize(std::string word) {
      std::string tokenized = lower(word);
      std::sort(tokenized.begin(), tokenized.end());
      return tokenized;
    }
  };
}
#endif

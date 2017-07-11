#if !defined(HELLO_WORLD_H)
#define HELLO_WORLD_H

namespace leap {
  bool is_leap_year(int year) {
    return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
  }
}
#endif

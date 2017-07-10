#if !defined(HELLO_WORLD_H)
#define HELLO_WORLD_H

#include <string>

namespace hello_world {

  std::string hello() {
    return "Hello, World!";
  }

  std::string hello(const std::string& name) {
    return "Hello, " + name + "!";
  }

}

#endif

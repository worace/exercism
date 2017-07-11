#if !defined(HELLO_WORLD_H)
#define HELLO_WORLD_H
#include "boost/date_time/posix_time/posix_time.hpp"

using namespace boost::posix_time;

namespace gigasecond {
  const seconds gigasecond = seconds(1e9);
  ptime advance(ptime start) {
    return start + gigasecond;
  }
}
#endif

module BookKeeping
  VERSION = 3
end
class Gigasecond
  def self.from(time)
    time + (10**9)
  end
end

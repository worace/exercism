class Hamming
  VERSION = 2
  def self.compute(left, right)
    raise ArgumentError unless left.length == right.length
    left.chars.zip(right.chars).count do |lchar, rchar|
      lchar != rchar
    end
  end
end

Hamming.compute("AAA", "AAA")

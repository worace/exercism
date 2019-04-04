class Series
  attr_reader :digits
  def initialize(digits)
    @digits = digits.chars
  end

  def slices_manual(n)
    (0...digits.length).select do |i|
      i + n <= digits.length
    end.map do |i|
      digits[i...i + n].join
    end
  end

  def slices(n)
    if n > digits.length
      raise ArgumentError, "Slice length too long"
    end
    # digits.each_cons(n).map { |s| s.join }
    slices_manual(n)
  end
end

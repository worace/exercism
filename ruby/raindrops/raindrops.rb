module Raindrops
  extend self

  def div_by(number, divisor)
    number % divisor == 0
  end

  def divisors
    {3 => "Pling", 5 => "Plang", 7 => "Plong"}
  end

  def convert(number)
    sounds = divisors.select do |div, sound|
      div_by(number, div)
    end.map do |div, sound|
      sound
    end.join

    if sounds.empty?
      number.to_s
    else
      sounds
    end
  end
end

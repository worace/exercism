require 'set'

class Robot
  ALPHA = ("A".."Z").to_a
  DIGITS = ("0".."9").to_a

  def self.forget
    @@names = permutations
  end

  def self.permutations
    [ALPHA, ALPHA, DIGITS, DIGITS, DIGITS].map do |alphabet|
      alphabet.to_a.shuffle.lazy
    end.reduce do |a, b|
      a.flat_map do |outer|
        b.map do |inner|
          outer + inner
        end
      end
    end
  end

  def self.names
    @@names ||= permutations
  end

  def self.generate_name
    names.next
  end

  attr_reader :name
  def initialize
    reset
  end

  def reset
    @name = Robot.generate_name
  end
end

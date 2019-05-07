class Scrabble
  GROUPS = [[1,  %w(A E I O U L N S T R)],
            [2,  %w(D G)],
            [3,  %w(B C M P)],
            [4,  %w(F H V W Y)],
            [5,  %w(K)],
            [8,  %w(J X)],
            [10, %w(Q Z)]]
  SCORES = GROUPS.flat_map { |s, letters| letters.map { |l| [l, s] } }.to_h

  attr_reader :word
  def initialize(word)
    @word = word.to_s.gsub(/\W/,"")
  end

  def score
    word.upcase.chars.map { |c| SCORES.fetch(c, 0) }.reduce(0, :+)
  end

  def self.score(word)
    self.new(word).score
  end
end


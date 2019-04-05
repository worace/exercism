class Phrase
  attr_reader :word_count
  def initialize(text)
    @word_count = count(text)
  end

  def count(text)
    text.gsub(/( ')|(' )/, ' ')
      .downcase
      .split(/[^\w']+/)
      .reject(&:empty?).reduce(Hash.new) do |counts, word|
      counts.merge(word => counts.fetch(word, 0) + 1)
    end
  end
end

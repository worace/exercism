class Isogram
  def self.isogram?(word)
    word.gsub("-", "").split(" ").all? do |word|
      word.downcase.chars.uniq.count == word.length
    end
  end
end

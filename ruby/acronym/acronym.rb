class Acronym
  def self.abbreviate(words)
    words
      .split(/[\s-]/)
      .map(&:chr)
      .join
      .upcase
  end
end

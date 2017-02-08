from itertools import groupby
import re

def word_count(sentence):
    sentence = sentence.lower()
    sentence = (" ").join(sentence.split("_"))
    words = re.findall("\w+", sentence) # [w for w in re.split(r"[\t\n!!&@$%^&_,.:]", sentence) if len(w) > 0]
    groups = groupby(sorted(words))
    return dict([(word,len(list(occs))) for word,occs in groups])

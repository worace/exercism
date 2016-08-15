import string
from sets import Set
import re

def letters_only(string):
    return re.sub(r"[^a-zA-Z]", "", string).lower()

def is_pangram(string, alphabet = string.lowercase):
    lower_alphabet = [s.lower() for s in alphabet]
    return Set(lower_alphabet) == Set((letters_only(string)))

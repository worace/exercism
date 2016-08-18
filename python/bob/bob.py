import re

def numeric(string):
    return "".join(re.findall("[\d?]", string)) == string

def any(coll):
    return len(coll) > 0

def shouting(string):
    return any(re.findall("[a-zA-Z]", string)) and string.upper() == string

def asking(string):
    return string[-1] == "?"

def empty(string):
    return len(string) == 0

def hey(what):
    what = what.rstrip()
    if empty(what):
        return "Fine. Be that way!"
    elif shouting(what):
        return "Whoa, chill out!"
    elif asking(what):
        return "Sure."
    else:
        return "Whatever."

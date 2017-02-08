from itertools import takewhile, repeat
import string

def encode(string):
    chunks = []

    while len(string) > 0:
        letter = string[0]
        matches = takewhile(lambda c: c == letter, string)
        chunk = [char for char in matches]
        if (len(chunk) > 1):
            chunks.append(str(len(chunk)) + letter)
        else:
            chunks.append(letter)

        string = string[len(chunk):]

    return "".join(chunks)

def decode(encoded):
    decoded = []

    while len(encoded) > 0:
        chunk_digits = "".join(takewhile(lambda c: c in string.digits, encoded))

        compressed_letter = encoded[len(chunk_digits)]

        chunk_length = int(chunk_digits or "1")

        for i in range(chunk_length):
            decoded.append(compressed_letter)

        encoded = encoded[len(chunk_digits) + 1:]


    return "".join(decoded)

# Adventure Binary Serializer

A library for [adventure](https://github.com/KyoriPowered/adventure) that serializes Components to packed bytes  
The format is intended for transmission over a network or short-term storage

## Fork
This is a fork of the original [adventure-binary-serializer](https://github.com/Moulberry/adventure-binary-serializer) by Moulberry.

## Advantages compared to GSON Serializer
The packed byte format is smaller than the JSON format, making it useful for transmission over a network (eg. chat between servers) or short-term storage  

## Warning
This format should not be used for long-term storage of Components  
This library does **NOT** guarantee back-compatibility between Component versions  

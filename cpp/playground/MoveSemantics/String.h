#pragma once

#include <cstdint>
#include <cstring>
#include <iosfwd>
#include <iostream>

class String
{
public:
    // Constructor from raw C-string — allocates a new buffer and copies data.
    String(const char* str)
    {
        std::cout << "Creating string" << std::endl;
        m_Size = strlen(str);
        m_Buffer = new char[m_Size + 1];
        memcpy(m_Buffer, str, m_Size);
        m_Buffer[m_Size] = '\0';
    }

    // Copy constructor — performs a DEEP copy (allocates new buffer, copies bytes).
    // To make this a true shallow copy, remove the new allocation and just copy the pointer.
    // WARNING: a shallow copy requires careful ownership — use std::shared_ptr or manual ref-counting.
    String(const String& other) : m_Size(other.m_Size)
    {
        std::cout << "Copying string (deep)" << std::endl;
        m_Buffer = new char[m_Size + 1];
        memcpy(m_Buffer, other.m_Buffer, m_Size + 1);
    }

    // Move constructor — transfers ownership of the buffer from 'other' (an rvalue).
    // No allocation happens; we steal the pointer and null out the source.
    String(String&& other) noexcept
        : m_Buffer(other.m_Buffer)
        , m_Size(other.m_Size)
    {
        std::cout << "Moving string" << std::endl;
        other.m_Buffer = nullptr;
        other.m_Size = 0;
    }

    // Destructor — frees the owned buffer. Safe to call on a moved-from object (nullptr delete is a no-op).
    ~String()
    {
        std::cout << "Destroying string" << std::endl;
        delete[] m_Buffer;
    }

    // Element access (const). Note: returns char& despite const qualifier — allows mutation of buffer
    // through a const String reference (matches std::string behavior, but be aware of the implication).
    char& operator[](const unsigned int index) const
    {
        return m_Buffer[index];
    }

    // Print the string byte-by-byte to stdout.
    void Print() const
    {
        for (uint32_t i = 0; i < m_Size; ++i)
        {
            printf("%c", m_Buffer[i]);
        }
        printf("\n");
    }

    friend std::ostream& operator<<(std::ostream& stream, const String& string);

private:
    unsigned int m_Size = 0;
    char* m_Buffer = nullptr;
};

inline std::ostream& operator<<(std::ostream& stream, const String& string)
{
    stream << string.m_Buffer;
    return stream;
}

// Utility: print a String via std::cout. Takes const ref — no copy, no move.
void PrintString(const String& string)
{
    std::cout << string << std::endl;
}

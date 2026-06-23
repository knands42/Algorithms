#pragma once

#include "String.h"

class Entity
{
public:
    // Lvalue constructor — copies the incoming String into m_Name (deep copy via copy constructor).
    Entity(const String& name) : m_Name(name)
    {
    }

    // Rvalue (move) constructor — moves the incoming String into m_Name (no allocation, no copy).
    // std::move(name) casts 'name' to String&& so the move constructor of String is selected.
    Entity(String&& name) : m_Name(std::move(name))
    {
    }

    void PrintName() const
    {
        m_Name.Print();
    }

private:
    String m_Name;
};

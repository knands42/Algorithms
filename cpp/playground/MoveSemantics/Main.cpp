#include "String.h"
#include "Entity.h"

int main()
{
    // --- Deep copy demonstration ---
    // 'second' is constructed via the copy constructor (deep copy).
    // Modifying 'second' does NOT affect 'first' because they own separate buffers.
    const String first = "Airplane";
    const String second = first;
    second[1] = '1';

    // Print both — 'first' is unchanged, 'second' has the mutation.
    PrintString(first);   // "Airplane"
    PrintString(second);  // "A1rplane"

    // --- Move semantics demonstration ---
    // The string literal "r-value: temporary string" creates a temporary String (rvalue).
    // Entity's move constructor is selected, which moves the temporary into m_Name.
    // No deep copy occurs — the temporary's buffer is transferred.
    Entity entity("r-value: temporary string");
    entity.PrintName();

    std::cin.get();
}

# Upper / Lower Bounds und View Bounds
Wichtiges Thema um die Scala API lesen zu können. Anhand von zwei oder drei API Stellen (List o.ä.) lässt sich sehr gut erklären wie diese zu lesen ist. Sehr hilfreich


>[B >: A] is a lower type bound. It means that B is constrained to be a supertype of A.
>
>Similarly [B <: A] is an upper type bound, meaning that B is constrained to be a subtype of A.
>
>In the example you've shown, you're allowed to push an element of type B onto a stack containing A elements, but the result is a stack of B elements.

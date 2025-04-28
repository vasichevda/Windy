# WindyAppTestTask

📱 **Short description**:
Flow adder implemented according to the task
https://docs.google.com/document/d/15ItqZO0wvwNIV1D0fulQx907_397QLXWoTyMrnc0Q30/edit?tab=t.0
Develop a Flow that summarizes the values of other Flows.
1. UI - there should be 3 elements on the screen. An input field, a start button, and a text field for displaying information. When you click on the button, we get the N - number entered in the input field and start Flow. The result of the work should be displayed in a text field. Each update should be on a new line.
2. Flow. It is necessary to create an array of Flow<Int>, N quantities, each of which, after a delay in (index + 1) * 100, emits the value index + 1. That is, Flow with index 0 with a delay of 100 emits the value 1, Flow with index 1 with a delay of 200 emits the value 2.
3. Summation. The resulting Flow should sum the values of all N Flows. The summing Flow should return a value after updating each of the N Flows.
Important: The value on the screen should be added every 100ms.

## 🛠 Technologies
- Kotlin
- Android SDK version: **35**
- Architecture: MVVM
- Libraries: Coroutines, Compose

## ⚙️ Installation
Clone the repository:
   ``bash
   git clone https://github.com/vasichevda/Windy.git .git
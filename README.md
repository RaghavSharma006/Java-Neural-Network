# 🧠 Java Neural Network Digit Classifier

A lightweight neural network written in **Java** that classifies handwritten digits (0–9) using pretrained weights. Includes:

- 🧾 `Main2.java`: Predicts a digit from `input.csv` (MNIST image).
- ✍️ `Main.java`: Interactive 28×28 **Java-based paint GUI** to draw and predict digits.

---

## ✨ Features

- ✅ **CSV-Based Prediction** — Predict using real MNIST data from a `.csv` input.
- 🖌️ **Draw & Predict** — Use a built-in GUI to draw a digit and classify in real-time.
- 🧠 **Pretrained Weights** — Leverages weights exported from Python (e.g., TensorFlow).

---

## 🔧 How to Use

### Option 1: Predict from CSV (`Main2.java`)

1. Run the following **Python** snippet to generate a flattened MNIST digit:

    ```python
    from tensorflow.keras.datasets import mnist

    (train_images, train_labels), _ = mnist.load_data()

    # Find the first image of digit 1 (change to any label 0–9)
    for i, label in enumerate(train_labels):
        if label == 1:
            digit_1 = train_images[i]
            break

    # Flatten and normalize
    flat = digit_1.flatten().astype('float32') / 255.0

    # Print as CSV line
    print(','.join(f"{pixel:.6f}" for pixel in flat))
    ```

2. Copy the output and save it as:

    ```
    src/Input/input.csv
    ```

3. Run `Main2.java` to classify.

---

### Option 2: Draw a Digit (`Main.java`)

1. Run `Main.java`.
2. Use your mouse to draw a digit (0–9) on the 28×28 grid.
3. Click **Predict** to classify your digit instantly.

---

## 📁 Project Structure
```
src/
├── Main.java # GUI-based digit drawer
├── Main2.java # CSV input-based classifier
├── Input/
│ └── input.csv # Flattened image input
├── Weights/
│ ├── hiddenLayer1.csv
│ └── outputLayer.csv
├── Bias/
│ ├── hiddenLayer1.csv
│ └── outputLayer.csv
├── InputLayer.java
├── HiddenLayer.java
├── OutputLayer.java
├── NeuralNetwork.java
```

## ✅ Requirements

- Java 8+
- Python (optional, for generating test CSV)


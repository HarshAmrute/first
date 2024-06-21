import cv2
from fer import FER

def main():
    # Initialize the webcam
    video_capture = cv2.VideoCapture(0)

    # Initialize the emotion detector
    emotion_detector = FER(mtcnn=True)

    while True:
        # Capture frame-by-frame
        ret, frame = video_capture.read()

        # Detect emotions
        result = emotion_detector.detect_emotions(frame)

        # Display the results
        for face in result:
            (x, y, w, h) = face["box"]
            emotions = face["emotions"]
            dominant_emotion = max(emotions, key=emotions.get)

            # Draw a rectangle around the face
            cv2.rectangle(frame, (x, y), (x + w, y + h), (0, 255, 0), 2)

            # Label the emotion
            cv2.putText(frame, dominant_emotion, (x, y - 10), cv2.FONT_HERSHEY_SIMPLEX, 0.9, (36, 255, 12), 2)

        # Display the resulting frame
        cv2.imshow('Video', frame)

        # Break the loop if 'q' key is pressed
        if cv2.waitKey(1) & 0xFF == ord('q'):
            break

    # Release the webcam and close windows
    video_capture.release()
    cv2.destroyAllWindows()

if __name__ == "__main__":
    main()

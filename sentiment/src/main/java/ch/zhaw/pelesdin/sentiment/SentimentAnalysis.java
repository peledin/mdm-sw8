package ch.zhaw.pelesdin.sentiment;

import ai.djl.Application;
import ai.djl.Device;
import ai.djl.MalformedModelException;
import ai.djl.ModelException;
import ai.djl.inference.Predictor;
import ai.djl.modality.Classifications;
import ai.djl.repository.zoo.Criteria;
import ai.djl.repository.zoo.ModelNotFoundException;
import ai.djl.repository.zoo.ZooModel;
import ai.djl.training.util.ProgressBar;
import ai.djl.translate.TranslateException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public final class SentimentAnalysis {

    private static final Logger logger = LoggerFactory.getLogger(SentimentAnalysis.class);

    private SentimentAnalysis() {
    }

    public static void main(String[] args) throws IOException, TranslateException, ModelException {
        Classifications classifications = SentimentAnalysis.predict(null);
        logger.info(classifications.toString());
    }

    public static Classifications predict(String input)
            throws MalformedModelException, ModelNotFoundException, IOException, TranslateException {
        logger.info("input Sentence: {}", input);

        Criteria<String, Classifications> criteria = Criteria.builder()
                .optApplication(Application.NLP.SENTIMENT_ANALYSIS)
                .setTypes(String.class, Classifications.class)
                .optDevice(Device.cpu())
                .optProgress(new ProgressBar())
                .build();

        try (ZooModel<String, Classifications> model = criteria.loadModel();
                Predictor<String, Classifications> predictor = model.newPredictor()) {
            return predictor.predict(input);
        }
    }

}
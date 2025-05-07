package backend.academy.factory;

import backend.academy.service.Transformation;
import backend.academy.service.impl.transformation.FisheyeTransformation;
import backend.academy.service.impl.transformation.HandkerchiefTransformation;
import backend.academy.service.impl.transformation.PolarTransformation;
import backend.academy.service.impl.transformation.SphericalTransformation;
import backend.academy.service.impl.transformation.SwirlTransformation;
import java.util.ArrayList;
import java.util.List;

public class TransformationFactory {
    public List<Transformation> getTransformations(String[] transformationsName) {
        List<Transformation> transformations = new ArrayList<>();
        for (String transformation : transformationsName) {
            switch (transformation.toLowerCase()) {
                case "spherical":
                    transformations.add(new SphericalTransformation());
                    continue;
                case "polar":
                    transformations.add(new PolarTransformation());
                    continue;
                case "swirl":
                    transformations.add(new SwirlTransformation());
                    continue;
                case "fisheye":
                    transformations.add(new FisheyeTransformation());
                    continue;
                case "handkerchief":
                    transformations.add(new HandkerchiefTransformation());
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + transformation.toLowerCase());
            }
        }
        return transformations;
    }
}

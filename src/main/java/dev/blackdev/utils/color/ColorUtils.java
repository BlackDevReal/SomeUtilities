package utils.color;

public class ColorUtils {

    // --- HEX <-> RGB ---

    public static int[] hexToRgb(String hex) {
        hex = hex.replace("#", "");
        int r = Integer.parseInt(hex.substring(0, 2), 16);
        int g = Integer.parseInt(hex.substring(2, 4), 16);
        int b = Integer.parseInt(hex.substring(4, 6), 16);
        return new int[]{r, g, b};
    }

    public static String rgbToHex(int r, int g, int b) {
        return String.format("#%02X%02X%02X", r, g, b);
    }

    // --- RGB <-> HSL ---

    public static float[] rgbToHsl(int r, int g, int b) {
        float rNorm = r / 255f;
        float gNorm = g / 255f;
        float bNorm = b / 255f;

        float max = Math.max(rNorm, Math.max(gNorm, bNorm));
        float min = Math.min(rNorm, Math.min(gNorm, bNorm));
        float h = 0f, s, l = (max + min) / 2f;

        if (max == min) {
            h = s = 0f; // achromatic
        } else {
            float d = max - min;
            s = l > 0.5 ? d / (2f - max - min) : d / (max + min);

            if (max == rNorm)
                h = (gNorm - bNorm) / d + (gNorm < bNorm ? 6f : 0f);
            else if (max == gNorm)
                h = (bNorm - rNorm) / d + 2f;
            else
                h = (rNorm - gNorm) / d + 4f;

            h /= 6f;
        }

        return new float[]{h * 360f, s * 100f, l * 100f};
    }

    public static int[] hslToRgb(float h, float s, float l) {
        h /= 360f;
        s /= 100f;
        l /= 100f;

        float r, g, b;

        if (s == 0) {
            r = g = b = l; // achromatic
        } else {
            float q = l < 0.5 ? l * (1f + s) : (l + s - l * s);
            float p = 2f * l - q;
            r = hueToRgb(p, q, h + 1f / 3f);
            g = hueToRgb(p, q, h);
            b = hueToRgb(p, q, h - 1f / 3f);
        }

        return new int[]{
                Math.round(r * 255f),
                Math.round(g * 255f),
                Math.round(b * 255f)
        };
    }

    private static float hueToRgb(float p, float q, float t) {
        if (t < 0f) t += 1f;
        if (t > 1f) t -= 1f;
        if (t < 1f / 6f) return p + (q - p) * 6f * t;
        if (t < 1f / 2f) return q;
        if (t < 2f / 3f) return p + (q - p) * (2f / 3f - t) * 6f;
        return p;
    }

    // --- HEX <-> HSL ---

    public static float[] hexToHsl(String hex) {
        int[] rgb = hexToRgb(hex);
        return rgbToHsl(rgb[0], rgb[1], rgb[2]);
    }

    public static String hslToHex(float h, float s, float l) {
        int[] rgb = hslToRgb(h, s, l);
        return rgbToHex(rgb[0], rgb[1], rgb[2]);
    }
}

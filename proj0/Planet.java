public class Planet
{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static final double G = 6.67e-11;
    public Planet(double xP, double yP, double xV,
              double yV, double m, String img)
              {
                  xxPos = xP;
                  yyPos = yP;
                  xxVel = xV;
                  yyVel = yV;
                  mass = m;
                  imgFileName = img;
              }

    public Planet(Planet p)       
    {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }   

    public double calcDistance(Planet p)
    {
        return Math.pow((Math.pow(p.xxPos - this.xxPos, 2) + (Math.pow(p.yyPos - this.yyPos, 2))), 0.5);
    }

    public double calcForceExertedBy(Planet p)
    {
        
        return G * this.mass * p.mass / Math.pow(calcDistance(p), 2);
    }

    public double calcForceExertedByX(Planet p)
    {
        return calcForceExertedBy(p) * (p.xxPos - this.xxPos) / calcDistance(p);
    }

    public double calcForceExertedByY(Planet p)
    {
        return calcForceExertedBy(p) * (p.yyPos - this.yyPos) / calcDistance(p);
    }

	public boolean equals (Planet p) 
    {
		boolean res = true;
		if (xxPos != p.xxPos) {
			res = false;
		}
		if (yyPos != p.yyPos) {
			res = false;
		}
		if (xxVel != p.xxVel) {
			res = false;
		}
		if (yyVel != p.yyVel) {
			res = false;
		}
		if (mass != p.mass) {
			res = false;
		}
		if (imgFileName != p.imgFileName) {
			res = false;
		}
		return res;
	}

    public double calcNetForceExertedByX(Planet[] all)
    {
        double netforce = 0;
        for(Planet p : all)
        {
            if(!equals(p)) netforce += calcForceExertedByX(p);
        }
        return netforce;
    }

    public double calcNetForceExertedByY(Planet[] all)
    {
        double netforce = 0;
        for(Planet p : all)
        {
            if(!equals(p)) netforce += calcForceExertedByY(p);
        }
        return netforce;
    }

    public void update(double dt,double xxForce, double yyForce)
    {
        double xxAc, yyAc;
        xxAc = xxForce / mass;
        yyAc = yyForce / mass;
        xxVel += xxAc * dt;
        yyVel += yyAc * dt;
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }

    public void draw()
    {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
        StdDraw.show();
    }

}


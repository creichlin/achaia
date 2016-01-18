# achaia
Oh you Romans you!

Defines a simple object tree with attributes and types. Is parsed and translated into an Object Tree where all the definitions can be fetched from.

## Example definition

    blog {
      title: string
      posts: [{
        title: string
        slug: slug
        date: date
        content: string
        comments: [{
          name: string
          email: string
          content: string
        }]
        views: [date]
      }]
    }
  
